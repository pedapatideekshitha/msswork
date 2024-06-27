const express = require('express');
const axios = require('axios');
const app = express();
const port = 3000;
var sql = require('mysql');

app.use(express.json());

// var con = sql.createConnection({
//     host: "localhost",
//     user: "root",
//     password: "M1racle@123",
//     database: "Employee"
// });


//   con.connect(function(err) {
//     if (err) throw err;
//     console.log("Connected!");
//   });

// app.post('/:id', (req, res) => {
//     const id = req.params.id;
//     let sql = "select * from Emp_Pro_Details where emp_id=?";
//     con.query(sql, [id], (error, result, fields) => {
//         if (!error) {
//             res.json(result);
//         }
//         else {
//             console.log(error);
//         }
//     })
// })




// let data = JSON.stringify({
//     "m": "hello"
//   });

//   let config = {
//     method: 'post',
//     maxBodyLength: Infinity,
//     url: 'http://172.17.15.185:8080',
//     headers: { 
//       'Content-Type': 'application/json'
//     },
//     data : data
//   };

// app.get('/',(req,res)=>{
//     axios.request(config)
//     .then((response) => {
//       console.log(JSON.stringify(response.data));
//     })
//     .catch((error) => {
//       console.log("Error",error);
//       res.send(req.body)

//     });

// })




app.get('/:mess', (req, res) => {
    console.log(req.body);
    let data = JSON.stringify({
        "messages": [
          {
            "role": "system",
            "content": "You are an AI assistant that helps people find information."
          },
          {
            "role": "user",
            "content": req.params.mess
          },
          {
            "role": "assistant",
            "content": "My role is to assist people in finding information by answering questions, providing recommendations, and offering guidance on various topics. I use natural language processing and machine learning algorithms to understand the user's request and provide relevant and accurate information."
          }
        ],
        "max_tokens": 800,
        "temperature": 0.7,
        "frequency_penalty": 0,
        "presence_penalty": 0,
        "top_p": 0.95,
        "stop": null
      });
      
      let config = {
        method: 'post',
        maxBodyLength: Infinity,
        url: 'https://aisample.openai.azure.com/openai/deployments/gpt-35-turbo/chat/completions?api-version=2024-02-15-preview',
        headers: { 
          'Content-Type': 'application/json', 
          'api-key': '71da79980641454fab3495033a429e71'
        },
        data : data
      };
      
      axios.request(config)
      .then((response) => {
        res.send(response.data.choices[0].message)
        console.log(JSON.stringify(response.data));
      })
      .catch((error) => {
        console.log(error);
      });
});


app.post('/', (req, res) => {
    res.send("success")
})

app.put('/', (req, res) => {
    res.send('put method successful')
})

app.delete('/', (req, res) => {
    res.send('delete method successful')
})
app.listen(port, () => console.log("server running"));