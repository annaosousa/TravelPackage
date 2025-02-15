async function getTrip(event) {
    event.preventDefault();

    const tripData = {
        type: "round-trip",
        origin: document.getElementById("origin").value,
        destination: document.getElementById("destination").value,
        departure_date: document.getElementById("departure_date").value,
        return_date: document.getElementById("return_date").value,
        num_people: parseInt(document.getElementById("num_people").value)
    };

    try {
        const response = await fetch("http://localhost:8080/api.bookTrip", { // Agora chamando o Envoy
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(tripData)
        });

        if (!response.ok) {
            throw new Error(`Erro na requisição: ${response.status}`);
        }

        const data = await response.json();

        document.getElementById("result").innerHTML = `
            <p>Status: ${data.status}</p>
            <p>Voo: ${data.flight_details}</p>
            <p>Hotel: ${data.hotel_details}</p>
            <p>Carro: ${data.car_details}</p>
        `;
    } catch (error) {
        console.error("Erro ao reservar:", error);
        document.getElementById("result").innerHTML = `<p style="color: red;">Erro ao reservar: ${error.message}</p>`;
    }
}

// Adiciona o evento ao formulário
document.getElementById("tripForm").addEventListener("submit", getTrip);
