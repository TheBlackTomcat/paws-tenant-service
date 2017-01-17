package paws.tenant.service.domain

import paws.library.service.domain.{Aggregate, Entity, EntityID, ValueObject}

case class Tenant(id: EntityID,
                  name: TenantName)
  extends Entity with Aggregate

case class TenantName(name: String) extends ValueObject {
  require(name != null && !name.isEmpty)
}