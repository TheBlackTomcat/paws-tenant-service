package paws.tenant.service.domain

import paws.library.service.domain.{EntityID, Repository}

trait TenantRepository extends Repository {
  def add(tenant: Tenant): Unit
  def get(id: EntityID): Option[Tenant]
}
