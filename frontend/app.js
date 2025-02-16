var express = require('express');
var grpc = require('@grpc/grpc-js');
var protoLoader = require('@grpc/proto-loader');
var cors = require('cors'); // Importar o CORS

var app = express();
app.use(express.json()); // Permitir JSON no corpo das requisições

// Habilitar o CORS para todas as origens
app.use(cors()); // Configuração global do CORS

// Carregar o arquivo .proto
const packageDefinition = protoLoader.loadSync('../src/main/proto/helloworld.proto', {
  keepCase: true,
  longs: String,
  enums: String,
  defaults: true,
  oneofs: true
});

// Obter a definição do serviço TravelAgency
const travelProto = grpc.loadPackageDefinition(packageDefinition).helloworld;

// Criar cliente gRPC para o TravelAgencyServer (porta 50083)
const travelAgencyClient = new travelProto.TravelAgency('localhost:50083', grpc.credentials.createInsecure());

app.get('/book-trip', (req, res) => {
  res.sendFile(__dirname + '/public/index.html');
});

// Rota para reservar uma viagem
app.post('/book-trip', (req, res) => {
  const { type, origin, destination, departure_date, return_date, num_people } = req.body;

  // Criar a requisição para o TravelAgencyServer
  const tripRequest = {
    type,
    origin,
    destination,
    departure_date,
    return_date,
    num_people
  };

  // Chamar o serviço TravelAgency -> BookTrip
  travelAgencyClient.BookTrip(tripRequest, (error, response) => {
    if (error) {
      console.error('Erro no gRPC:', error);
      return res.status(500).json({ error: 'Erro ao reservar viagem', details: error.details });
    }

    // Responder ao cliente com os detalhes da viagem
    res.json(response);
  });
});

// Iniciar o servidor Express na porta 50084
app.listen(50084, function () {
  console.log('Agência de Viagens ouvindo na porta 50084!');
});
