package toolbox.config
object ConfigDemo extends Application {
  val cfg = Config("dev")
  val fooDao = cfg.fooDao
  println(fooDao.get(1))
  //println(toolbox.scalasupport.RichSystem.props)
}

object Config {
  def apply(env: String) = new Config(env)
}
class Config(env: String) {
  val props = PropertiesFile("conf/"+env+"/config.properties")
  val fooDao: FooDao = new FooDaoImpl{ val maxBar = props.get("maxBar")
}

import scala.collection.jcl.MapWrapper
object PropertiesFile {
  def apply(name: String): MapWrapper[String, String] = {
    val props = new java.util.Properties
    props.load(new java.io.FileInputStream(name))
    new MapWrapper[String, String]{
      def underlying = props.asInstanceOf[java.util.Map[String,String]]
    }
  }
}

/// test data
case class User(id: Int, uname: String, pwd: String)
trait FooDao{
  def save(user: User): Unit
  def get(id: Int): User
}
class FooDaoImpl extends FooDao{
  val int maxBar = 8
  def save(user: User) = println("Saving " +user)
  def get(id: Int) = new User(1, "zman", "foo")  
}
