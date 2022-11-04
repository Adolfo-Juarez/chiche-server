# Chiché Server
API de la página web de una tienda de postres llamada "Chiché", desarrollada en **Java** con **Spring-boot**.

## Endpoints
### Cake
http://localhost:8080/cake
##### Route
http://localhost:8080/cake/**id**

##### Request
```Javascript
import axios from 'axios'
import { useState } from 'React'

const { info, setInfo } = useState(null)

let id = 3

let result = await axios.get(`http://localhost:8080/${id}`)
                        .then((response)=>{ setInfo(response.data) })
```
##### Response
```JSON
{
    "id":3,
    "biscuit":"Chocolate"
}
```