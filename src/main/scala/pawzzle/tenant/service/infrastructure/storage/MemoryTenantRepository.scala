package pawzzle.tenant.service.infrastructure.storage

import pawzzle.library.service.domain.EntityID
import pawzzle.library.service.infrastructure.StorageAdapter
import pawzzle.tenant.service.domain.{Tenant, TenantRepository}

/**
  * Dummy in-memory implementation of the tenant repository as a storage adapter.
  */
class MemoryTenantRepository extends StorageAdapter with TenantRepository {

  override def add(tenant: Tenant): Unit = MemoryStorageManager.put(tenant.id, tenant)

  override def get(id: EntityID): Option[Tenant] = MemoryStorageManager.get(id).flatMap(_.asInstanceOf)
}

