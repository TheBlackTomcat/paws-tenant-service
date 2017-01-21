package paws.tenant.service.domain

import paws.library.service.domain.{EntityID, Event}

/**
  * Trait that groups together all the events related to the Tenant bounded context.
  */
sealed trait TenantEvent extends Event

/**
  * Domain Event announcing a tenant has been provisioned.
  */
case class TenantProvisionedEvent(id: EntityID) extends TenantEvent