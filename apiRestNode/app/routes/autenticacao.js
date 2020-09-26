const auth = require('../controllers/autenticacao')

module.exports = function(app){
    app.get('/autenticacao/:usuario/:senha/', auth.autenticar )
}