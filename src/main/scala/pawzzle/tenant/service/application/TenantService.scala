package pawzzle.tenant.service.application

import pawzzle.library.service.application.Service
import pawzzle.library.service.domain.EntityID
import pawzzle.tenant.service.domain.{Tenant, TenantName, TenantRepository}

/**
  * The TenantService trait defining the possible operations on the Tenant domain.
  */
sealed trait TenantService extends Service {

  /**
    * Creates a new Tenant with the provided data. The tenant cannot be used until it is provisioned.
    *
    * @param data The tenant related data used to create the tenant.
    */
  def createTenant(data: CreateTenantData): Unit

  /**
    * Loads the tenant related data identified by tenant id. Returns an Option[TenantInfoData] containing the tenant
    * data or None if the tenant cannot be identified.
    *
    * @param data The data to identify the tenant by.
    * @return The tenant related data that exists in the repository.
    */
  def loadTenant(data: LoadTenantByIdData): Option[TenantInfoData]

  def loadTenant(data: LoadTenantByNameData): Option[TenantInfoData]

  def loadTenants(): Set[TenantInfoData]

  /**
    * Provisions an already created tenant. After provisioning the tenant becomes active and can be used.
    *
    * @param data The data used to identify the tenant to be provisioned.
    */
  def provisionTenant(data: ProvisionTenantData): Unit
}

/**
  * The default implementation of the tenant service.
  */
class TheTenantService extends TenantService {

  private val repo: TenantRepository = TenantRepository()

  override def start(): Unit = {
    println("TenantService successfully started.")
  }

  override def restart(): Unit = {}

  override def shutdown(): Unit = {
    println("TenantService successfully shutdown.")
  }

  override def createTenant(data: CreateTenantData): Unit = {
    require(data != null, "The tenant data should be provided when creating a new tenant.")
    val id = repo.uniqueId()
    val tenant = Tenant(id, TenantName(data.name))
    repo.add(tenant)
  }

  override def loadTenant(data: LoadTenantByIdData): Option[TenantInfoData] = {
    require(data != null, "The tenant id should be provided when loading an existing tenant.")
    repo.get(EntityID(data.id)) match {
      case Some(t) => Some(TenantInfoData(t))
      case None => None
    }
  }

  override def loadTenant(data: LoadTenantByNameData): Option[TenantInfoData] = {
    require(data != null, "The tenant name should be provided when loading an existing tenant.")
    repo.get(TenantName(data.name)) match {
      case Some(t) => Some(TenantInfoData(t))
      case None => None
    }
  }

  override def loadTenants(): Set[TenantInfoData] = {
    repo.getAll().map(TenantInfoData(_)).toSet
  }

  override def provisionTenant(data: ProvisionTenantData): Unit = throw new UnsupportedOperationException
}