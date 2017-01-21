package pawzzle.tenant.service.domain

import pawzzle.library.service.domain.{EntityID, Service}

/**
  * Domain Service for Tenant related operations that cannot be expressed inside the Tenant aggregate due to increased
  * complexity.
  */
class TenantService extends Service {

  /**
    * Provisions a tenant and generates a TenantProvisionedEvent domain event.
    * @param id The id of the tenant to be provisioned.
    */
  def provisionTenant(id: EntityID): Unit = throw new UnsupportedOperationException
}
