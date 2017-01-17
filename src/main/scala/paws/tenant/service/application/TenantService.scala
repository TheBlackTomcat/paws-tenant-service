package paws.tenant.service.application

import paws.library.service.application.Service
import paws.library.service.domain.EntityID
import paws.tenant.service.domain.TenantRepository
import paws.tenant.service.infrastructure.MemoryTenantRepository

sealed trait TenantService extends Service {
  def createTenant(tenantData: TenantData): Unit
  def loadTenant(id: String): Option[TenantData]
  def provisionTenant(id: String): Unit
}

class TheTenantService extends TenantService {

  private val repo: TenantRepository = new MemoryTenantRepository()

  override def createTenant(tenantData: TenantData): Unit = {
    require(tenantData.id.isEmpty, "Tenant id should not be provided when creating a tenant.")
    require(tenantData.name != null && !tenantData.name.isEmpty, "Tenant name should be provided when creating a tenant.")

    val id = repo.uniqueId()
    val tenant = TenantMapper.mapToEntity(id, tenantData)
    repo.add(tenant)
  }

  override def loadTenant(id: String): Option[TenantData] = {
    require(id != null, "The tenant id should be provided.")
    repo.get(EntityID(id)).map(TenantMapper.mapToData)
  }

  override def provisionTenant(id: String): Unit = throw UnsupportedOperationException
}