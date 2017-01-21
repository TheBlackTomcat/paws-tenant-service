package paws.tenant.service.infrastructure.storage

import paws.library.service.domain.EntityID
import paws.library.service.infrastructure.StorageAdapter
import paws.tenant.service.domain.{Tenant, TenantRepository}

/**
  * Dummy in-memory implementation of the tenant repository as a storage adapter.
  */
class MemoryTenantRepository extends StorageAdapter with TenantRepository {

  override def add(tenant: Tenant): Unit = MemoryStorageManager.put(tenant.id, tenant)

  override def get(id: EntityID): Option[Tenant] = MemoryStorageManager.get(id).flatMap(_.asInstanceOf)
}

