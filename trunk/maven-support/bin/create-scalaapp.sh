if [[ $# < 2 ]]; then
	echo "create-javaapp.sh <groupId> <artifactId>"
	exit 1
fi

mvn archetype:create \
  -DremoteRepositories=http://faxintelligence.com:8082/archiva/repository/internal \
  -DarchetypeGroupId=javasupport.maven \
  -DarchetypeArtifactId=maven-archetype-scalaapp \
  -DarchetypeVersion=0.0.1 \
  -DgroupId=$1 \
  -DartifactId=$2