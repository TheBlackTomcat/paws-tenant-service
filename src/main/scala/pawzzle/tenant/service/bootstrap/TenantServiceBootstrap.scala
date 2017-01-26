package pawzzle.tenant.service.bootstrap

import pawzzle.library.service.bootstrap.{Configuration, ServiceBootstrap}
import pawzzle.tenant.service.application.{CreateTenantData, LoadTenantByIdData, LoadTenantByNameData, TenantService}

/**
  * Bootstrap object for launching the TenantService.
  */
object TenantServiceBootstrap extends App {

  val service = ServiceBootstrap(Configuration()).boot[TenantService]()

  service.start()

  service.createTenant(CreateTenantData("DemoTenant 1"))
  service.createTenant(CreateTenantData("DemoTenant 2"))
  service.createTenant(CreateTenantData("DemoTenant 3"))
  service.createTenant(CreateTenantData("DemoTenant 4"))

  val tenantByName = service.loadTenant(LoadTenantByNameData("DemoTenant 1"))
  println("DemoTenant: " + tenantByName)

  val tenantById = service.loadTenant(LoadTenantByIdData(tenantByName.get.id))
  println("DemoTenant: " + tenantById)

  val tenants = service.loadTenants()
  println("Tenants: " + tenants)

  service.shutdown()
}