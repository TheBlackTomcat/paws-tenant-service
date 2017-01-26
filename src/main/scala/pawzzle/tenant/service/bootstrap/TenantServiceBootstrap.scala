package pawzzle.tenant.service.bootstrap

import pawzzle.library.service.bootstrap.{Configuration, ServiceBootstrap}
import pawzzle.tenant.service.application.TenantService

/**
  * Bootstrap object for launching the TenantService.
  */
object TenantServiceBootstrap extends App {

  ServiceBootstrap(Configuration()).boot[TenantService]()
}