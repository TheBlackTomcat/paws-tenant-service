package pawzzle.tenant.service.application

import pawzzle.library.service.application.DataTransferObject
import pawzzle.library.service.domain.Factory
import pawzzle.tenant.service.domain.Tenant

/**
  * Trait that groups together all the data transfer objects related to the Tenant bounded context.
  */
sealed trait TenantData extends DataTransferObject

/**
  * Data transfer object used as input for the createTenant operation in the application service TenantService.
  * @param name The name of the tenant to be created.
  */
case class CreateTenantData(name: String) extends TenantData

/**
  * Data transfer object used as input for the loadTenant operation in the application service TenantService.
  * @param id The id of the tenant to be loaded.
  */
case class LoadTenantByIdData(id: String) extends TenantData

/**
  * Data transfer object used as input for the loadTenant operation in the application service TenantService.
  * @param name The name of the tenant to be loaded.
  */
case class LoadTenantByNameData(name: String) extends TenantData

/**
  * Data transfer object used as output for the loadTenant operation in the application service TenantService.
  * @param id The id of the loaded tenant.
  * @param name The name of the loaded tenant.
  * @param status The status of the loaded tenant.
  */
case class TenantInfoData(id: String, name: String, status: String) extends TenantData

/**
  * Data transfer object used as input for the provisionTenant operation in the application service TenantService.
  * @param id The id of the tenant to be provisioned.
  */
case class ProvisionTenantData(id: String) extends TenantData

/**
  * Factory for creating a LoadTenantOutputData based on a Tenant entity.
  * This is private[application] since it must not be used outside the application layer, as we do not want our domain
  * entity Tenant leaked out of the application boundary.
  */
private[application] object TenantInfoData extends Factory {
  def apply(tenant: Tenant): TenantInfoData = {
    TenantInfoData(tenant.id.id, tenant.name.name, tenant.status.status)
  }
}