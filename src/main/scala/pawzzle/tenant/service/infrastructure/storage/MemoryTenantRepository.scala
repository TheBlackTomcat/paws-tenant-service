package pawzzle.tenant.service.infrastructure.storage

import pawzzle.library.service.domain.EntityID
import pawzzle.library.service.infrastructure.DataAccessAdapter
import pawzzle.tenant.service.domain.{Tenant, TenantName, TenantRepository}

/**
  * Dummy in-memory implementation of the tenant repository as a storage adapter.
  */
class MemoryTenantRepository extends DataAccessAdapter with TenantRepository {

  override def add(tenant: Tenant): Unit = {
    MemoryStorageManager.put(tenant.id, tenant)
    MemoryStorageManager.put(tenant.name, tenant)
  }

  override def get(id: EntityID): Option[Tenant] = MemoryStorageManager.get(id).map((t) => t.asInstanceOf[Tenant])

  override def get(name: TenantName): Option[Tenant] = MemoryStorageManager.get(name).map((t) => t.asInstanceOf[Tenant])

  override def getAll(): Iterable[Tenant] = MemoryStorageManager.getAll().map((t) => t.asInstanceOf[Tenant])
}