# Documentación del proyecto
## Creado la carpeta
´´´shell
mkdir deployments
chmod -R 777 deployments
´´´

## Copiando el fichero csv
´´´shell
cp input.csv /tmp
´´´

## Levantando el servicio

´´´shell
docker compose up -d
´´´
## Creación del usuario
´´´shell
docker compose exec wildfly bash
/opt/jboss/wildfly/bin/add-user.sh user_admin admin_password --silent
´´´
