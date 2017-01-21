package pawzzle.tenant.service.domain

import pawzzle.library.service.domain.{EntityID, Repository}

/**
  * Trait that defines the possible operations related to data storage for the Tenant aggregate.
  */
trait TenantRepository extends Repository {

  /**
    * Adds a new Tenant by creating a new entry in the repository.
    * @param tenant The tenant entity to be added.
    */
  def add(tenant: Tenant): Unit

  /**
    * Get the tenant related data from the repository.
    * @param id The id of the tenant to be retrieved.
    * @return The Tenant identified by the tenant id.
    */
  def get(id: EntityID): Option[Tenant]
}
