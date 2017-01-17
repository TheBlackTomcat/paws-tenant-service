package paws.tenant.service.infrastructure

import paws.library.service.domain.{Entity, EntityID}
import paws.tenant.service.domain.{Tenant, TenantRepository}

import scala.collection.mutable

class MemoryTenantRepository extends TenantRepository {

  val storage = mutable.Map.empty[EntityID, Entity]

  override def add(tenant: Tenant): Unit = storage.put(tenant.id, tenant)

  override def get(id: EntityID): Option[Tenant] = storage.get(id).flatMap(_.asInstanceOf)
}
