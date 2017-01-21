package paws.tenant.service.infrastructure.storage

import scala.collection.mutable

/**
  * External dummy data storage manager implementation.
  */
object MemoryStorageManager {

  private val storage = mutable.Map.empty[Any, Any]

  def put(key: Any, value: Any): Unit = storage.put(key, value)

  def get(key: Any): Option[Any] = storage.get(key)
}
