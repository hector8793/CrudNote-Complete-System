const express = require('express')
const cors = require('cors')
const path = require('path')
const app = express();

const usersRoutes = require('./routes/users')

app.set('views', path.join(__dirname, 'views'))
app.set('port', process.env.PORT || 3000);
app.engine('html', require('ejs').renderFile)
app.set('view engine', 'ejs')

app.use(cors());
app.use(express.json());

// app.use(indexRoutes)
app.use('/api', usersRoutes)

app.use(express.static(path.join(__dirname, 'dist')))

app.listen(3000, () => {
    console.log("iniciando");
})