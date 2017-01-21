package pawzzle.tenant.service.application

import pawzzle.library.service.application.Service
import pawzzle.library.service.domain.EntityID
import pawzzle.tenant.service.domain.{Tenant, TenantName, TenantRepository}
import pawzzle.tenant.service.infrastructure.storage.MemoryTenantRepository

/**
  * The TenantService trait defining the possible operations on the Tenant domain.
  */
sealed trait TenantService extends Service {

  /**
    * Creates a new Tenant with the provided data. The tenant cannot be used until it is provisioned.
    * @param data The tenant related data used to create the tenant.
    */
  def createTenant(data: CreateTenantInputData): Unit

  /**
    * Loads the tenant related data. Returns an Option containing the Tenant data or None if the tenant cannot be
    * identified.
    * @param data The data to identify the tenant by.
    * @return The Tenant related data that exists in the repository.
    */
  def loadTenant(data: LoadTenantInputData): Option[LoadTenantOutputData]

  /**
    * Provisions an already created tenant. After provisioning the tenant becomes active and can be used.
    * @param data The data used to identify the tenant to be provisioned.
    */
  def provisionTenant(data: ProvisionTenantInputData): Unit
}

/**
  * The default implementation of the tenant service.
  */
class TheTenantService extends TenantService {

  private val repo: TenantRepository = new MemoryTenantRepository()

  override def createTenant(data: CreateTenantInputData): Unit = {
    require(data != null && data.name != null, "The tenant name should be provided when creating a new tenant.")
    val id = repo.uniqueId()
    val tenant = Tenant(id, TenantName(data.name))
    repo.add(tenant)
  }

  override def loadTenant(data: LoadTenantInputData): Option[LoadTenantOutputData] = {
    require(data != null && data.id != null, "The tenant id should be provided when loading an existing tenant.")
    repo.get(EntityID(data.id)) match {
      case Some(t) => Some(LoadTenantOutputData(t))
      case None => None
    }
  }

  override def provisionTenant(data: ProvisionTenantInputData): Unit = throw new UnsupportedOperationException
}