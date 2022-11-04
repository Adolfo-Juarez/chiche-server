# Chiché Server
API for the website of a dessert store called "Chiché", developed in **Java** with **Spring-boot**.

## Endpoints
### Cake
http://localhost:8080/cake
##### GET - List
**Route**
```URL
http://localhost:8080/cake
```
**Response**
```JSON
{
    {
        "id":1,
        "biscuit":"Chocolate",
        "filling":"Mermelada",
        "coverage":"Example",
        "design":"print",
        "shape":"square",
        "size":"small",
        "subtotal":123,
        "total":456,
        "orderedAt":,
        "finish":false
    }
}
```

##### POST 
**Route**
```URL
http://localhost:8080/cake
```
**Body**
```JSON
{
    "biscuit":"Chocolate",
    "filling":"Mermelada",
    "coverage":"Example",
    "design":"print",
    "shape":"square",
    "size":"small",
}
```
**Response**
```JSON

{
    "id":1,
    "biscuit":"Chocolate",
    "filling":"Mermelada",
    "coverage":"Example",
    "design":"print",
    "shape":"square",
    "size":"small",
    "subtotal":123,
    "total":456,
    "orderedAt":,
    "finish":false
}

```

### Price
#### GET - Type
**Route**
```URL
http://localhost:8080/price/type?name=TYPE
```
#### GET - Description
**Route**
```URL
http://localhost:8080/price/description?name=DESCRIPTION
```
#### POST 
**Route**
```URL
http://localhost:8080/price
```
**Body**
```JSON
{
    "type":"Biscuit",
    "description":"Chocolate",
    "price":23
}
```
#### PUT
Only update the information of the first record with the given description, in case there is more than one registers with the same description.
**Route**
```URL
http://localhost:8080/price/DESCRIPTION
```

**Body**
```JSON
{
    "price":12
}
```