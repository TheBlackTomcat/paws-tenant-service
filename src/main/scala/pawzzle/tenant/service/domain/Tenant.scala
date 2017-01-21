package pawzzle.tenant.service.domain

import pawzzle.library.service.domain._

/**
  * The Tenant aggregate root entity.
  * @param id The unique tenant id used to identify the tenant inside the domain.
  * @param name The name of the tenant.
  * @param status The status of the tenant as defined by the implementations of the TenantStatus trait.
  */
case class Tenant(id: EntityID,
                  name: TenantName,
                  status: TenantStatus
                 ) extends Entity with Aggregate

/**
  * Factory object for the Tenant entity that defined additional construction options besides the default one.
  */
object Tenant extends Factory {
  def apply(id: EntityID, name: TenantName): Tenant = Tenant(id, name, NEW)
}

/**
  * Tenant name value object.
  * @param name The name of the tenant.
  */
case class TenantName(name: String) extends ValueObject {
  require(name != null && !name.isEmpty)
}

/**
  * Tenant status value object.
  * @param status The status name.
  */
sealed abstract class TenantStatus(val status: String) extends ValueObject

/**
  * The NEW status is assigned to a tenant right after the tenant is created.
  */
case object NEW extends TenantStatus("New")

/**
  * The ACTIVE status is assigned after a successful provisioning of the tenant or when a tenant has been suspended and
  * it is being reactivated.
  */
case object ACTIVE extends TenantStatus("Active")

/**
  * The SUSPENDED status is assigned when the tenant is not allowed to perform its operations anymore. A suspended
  * tenant can be reactivated by changing the status to ACTIVE.
  */
case object SUSPENDED extends TenantStatus("Suspended")

/**
  * The TERMINATED status is assigned when the tenant account is terminated. This is a final status and cannot changed
  * anymore. A terminated tenant cannot perform any operations, this is similar to a soft delete operation. All tenant
  * data will not be accessible anymore.
  */
case object TERMINATED extends TenantStatus("Terminated")