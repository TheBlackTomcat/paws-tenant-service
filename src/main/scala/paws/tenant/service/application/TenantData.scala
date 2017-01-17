package paws.tenant.service.application

import paws.library.service.application.DataTransferObject
import paws.library.service.domain.EntityID
import paws.tenant.service.domain.{Tenant, TenantName}

case class TenantData(id: Option[String], name: String) extends DataTransferObject

protected object TenantMapper {
  def mapToData(tenant: Tenant): TenantData = TenantData(Some(tenant.id.id), tenant.name.name)
  def mapToEntity(id: EntityID, tenantData: TenantData) = Tenant(id, TenantName(tenantData.name))
}