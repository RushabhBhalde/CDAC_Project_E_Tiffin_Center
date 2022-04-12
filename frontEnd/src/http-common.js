import axios from "axios";
export default axios.create({
    baseURL:'http://localhost:8081/customers',
    headers:{
        'content-type':'application/json',
    }
});