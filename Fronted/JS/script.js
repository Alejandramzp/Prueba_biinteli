function searchJourney() {
    const origin = document.getElementById('origin').value;
    const destination = document.getElementById('destination').value;

    fetch("http://localhost:8080/API/journeyFlights/search", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ origin: origin, destination: destination })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("No se encontraron resultados para este trayecto.");
        }
        return response.json();
    })
    .then(data => {
        console.log("Datos recibidos:", data); // Consola
        displayResult(data);
    })
    .catch(error => {
        document.getElementById("result").innerHTML = `<p>${error.message}</p>`;
    });
}

function displayResult(journeys) {
    const resultDiv = document.getElementById("result");
    resultDiv.innerHTML = "";

    if (!journeys || journeys.length === 0) {
        resultDiv.innerHTML = "<p>No se encontraron vuelos para este trayecto.</p>";
        return;
    }

    journeys.forEach((data, index) => {
        let journeyInfo = `
            <h2>Trayecto ${index + 1}: Desde ${data.origin} hasta ${data.destination}</h2>
            <p>Precio total: $${data.price.toFixed(2)}</p>
            <h3>Vuelos a Tomar:</h3>
            <ul>
        `;

        data.flights.forEach(flight => {
            journeyInfo += `
                <li>
                    <strong>De:</strong> ${flight.origin} <strong>a</strong> ${flight.destination} <br>
                    <strong>Precio:</strong> $${flight.price.toFixed(2)} <br>
                    <strong>Carrier:</strong> ${flight.transport.flight_carrier} <br>
                    <strong>Número de Vuelo:</strong> ${flight.transport.flight_number}
                </li><br>
            `;
        });

        journeyInfo += '</ul>';
        resultDiv.innerHTML += journeyInfo;
    });
}