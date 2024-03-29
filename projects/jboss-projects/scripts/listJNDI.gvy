import javax.naming.*

//Quick test
//def ctx = new InitialContext()
//def cf = ctx.doLookup("ConnectionFactory")
//println(cf)

// Listing a context names binding
def list(ctx) {
	println()
	println("Namespace: ${ctx.nameInNamespace}")
	//names sorted by className, then binding name. The element is a NameClassPair
	def names = ctx.list("").toList().sort { a, b -> 
		def ret = a.className.compareTo(b.className)
		if (ret == 0) {
			ret = a.name.compareTo(b.name)
		}
		return ret
	}
	names.each { nameClassPair ->
		if (nameClassPair.className.contains("org.jnp.interfaces.NamingContext")) {
			list(ctx.lookup(nameClassPair.name))
		} else {
			println("${nameClassPair.name} : ${nameClassPair.className}")
		}
	}
}
list(new InitialContext())
