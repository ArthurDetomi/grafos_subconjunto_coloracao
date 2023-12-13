all:
	./mvnw clean package
rodar_programa_pos_compilacao:
	java -jar target/oito_rainhas-1.0-SNAPSHOT.jar
rodar_programa_preparado:
	java -jar snapshots_jar/oito_rainhas-1.0-SNAPSHOT.jar