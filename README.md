# Enkel Webshop Backend

Detta är backend-systemet för en enkel webshop byggd med Java och Spring Boot. Projektet implementerar ett REST API för hantering av produkter och ordrar.

---

## Funktionalitet

- **Produkt-API:**
    - `GET /api/products` – Hämtar alla produkter.
    - `GET /api/products/{id}` – Hämtar detaljer för en specifik produkt.

- **Order-API:**
    - `POST /api/orders` – Skapar en ny order med produktlista och kunduppgifter.

---

## Teknisk information

- Java 17+
- Spring Boot 3.x
- Byggverktyg: Maven
- Data lagras i minnet med Java Collections (List, Map).
- JSON används som dataformat.
- Enhetstester skrivna med JUnit 5.
- Felhantering via global exception handler.

---

## Installation och körning

### Förutsättningar

- Java 17 eller senare
- Maven 3.x

---
## API Användning

### Produkthantering

#### Hämta alla produkter
`GET /api/products`  
Returnerar en lista med alla tillgängliga produkter.

**Exempel på svar:**
```json
[
  {
    "id": 1,
    "name": "Produkt A",
    "description": "Beskrivning av produkt A",
    "price": 99.9,
    "imageUrl": "http://exempel.com/bild.jpg",
    "stock": 10
  },
  {
    "id": 2,
    "name": "Produkt B",
    "description": "Beskrivning av produkt B",
    "price": 49.5,
    "imageUrl": "http://exempel.com/bild2.jpg",
    "stock": 5
  }
]
### 2. Hämta Produkt via ID  
**GET** `/api/products/1`  
Hämtar en Produkt med ID

**Svarsexempel:**
```json
[
  {
    "id": 1,
    "name": "Produkt A",
    "description": "Beskrivning av produkt A",
    "price": 99.9,
    "imageUrl": "http://exempel.com/bild.jpg",
    "stock": 10
  }
]
### 3. Skapa en Order 
**POST** `/api/orders`  
Skapar en order och tar emot 
kunduppgifter och en lista med produkter 
(Produkt-ID och kvantitet)Validerar ordern och sparar 
den i minnet.

**Svarsexempel:**
```json
{
  "customerInfo": {
    "name": "Anna Andersson",
    "address": "Blåsvägen 2, 12345 Stad",
    "email": "anna@example.com"
  },
  "items": [
    {
      "productId": 1,
      "quantity": 2
    },
    {
      "productId": 2,
      "quantity": 1
    }
  ]
}

**Svarsexempel på lyckad order**
{
  "orderId": 123,
  "message": "Order skapad framgångsrikt"
}

### Bygga och köra

```bash
git clone https://github.com/ditt-anvandarnamn/enkel-webshop-backend.git
cd enkel-webshop-backend
mvn clean install
mvn spring-boot:run

---
