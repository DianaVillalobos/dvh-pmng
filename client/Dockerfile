# Que imagen base vamos a usar
FROM nginx:alpine

# Eliminar archivos por defecto de la imagen
RUN rm -rf /usr/share/nginx/html/*

# Copiar nuetstro proyecto en la imagen
COPY . /usr/share/nginx/html

# Decir en que puerto exponer la imagen
EXPOSE 80