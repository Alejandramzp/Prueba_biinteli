# ✈️ VIAJE POR COLOMBIA - Propuesta de Solución Backend ✈️

La empresa VIAJE POR COLOMBIA necesita una solución para poder conectar viajes a través del mundo, esta solución debe recibir como parámetros el origen y el destino de viaje del usuario, después el sistema debe consultar todos los vuelos asociados que tenga, y devolver la ruta de viaje al usuario si la ruta es posible o un mensaje avisando que la ruta no se encuentra.

## 📜 Requisitos

1. **Backend**
   - MySQL
   - IntelliJ IDEA
2. **Frontend**
   - Visual Code
   - Live Server Extension

## ⬇️ Instalación

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/Alejandramzp/Prueba_biinteli.git
   
2. **Configurar la base de datos**
   - Crea la base de datos para la aplicación y configura los detalles de conexión en ```src/main/resources/application.properties ```
     
3. **Ejecutar la aplicación**
   - La API debería estar corriendo en ```http://localhost:8080```
  
## 📋 Uso de la API
La API proporciona el endpoint para interactuar con el sistema. Aquí hay una descripción de cómo usarlo:

### Búsqueda de Trayectos
- **Endpoint:** ```/API/journeyFlights/search```
- **Método:** ```POST```
- **Cuerpo de la solicitud:**
  ```json
  {
    "origin": "BGA",
    "destination": "CTG"
  }
  ```
 - **Descripción:** Este endpoint busca trayectos disponibles entre el origen y el destino proporcionados.
### Respuesta Esperada
La respuesta será un JSON con la siguiente estructura:
```json
[
    {
        "origin": "BGA",
        "destination": "CTG",
        "price": 3000.00,
        "flights": [
            {
                "origin": "BGA",
                "destination": "BTA",
                "price": 1000.00,
                "transport": {
                    "id": 1,
                    "flight_carrier": "AV",
                    "flight_number": "8020"
                }
            },
            {
                "origin": "BTA",
                "destination": "CTG",
                "price": 2000.00,
                "transport": {
                    "id": 2,
                    "flight_carrier": "AV",
                    "flight_number": "8030"
                }
            }
        ]
    }
]
```
## 🎨 Uso del Front
El Front proporciona una vista sencilla para interactuar con el sistema. Aquí hay una descripción de cómo usarlo:

1. **Abrir el Archivo index.html:** En el panel de exploración de Visual Studio Code, busca y abre el archivo ```index.html```
2. **Iniciar Live Server:** Haz clic derecho en el archivo ```index.html``` y selecciona la opción ```Open with Live Server```
3. **Visualizar Frontend:** Live Server abrirá tu archivo ```index.html``` en el navegador.

## 📝 Realizado por

Este proyecto fue desarrollado por:
- Paula Muñoz ➡️ [@Alejandramzp](https://github.com/Alejandramzp)
