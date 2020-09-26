const usuario       = require('../controllers/usuario')
const verificaToken = require('../middlewares/verificaToken')

module.exports = function(app){

    app.get('/usuarios', verificaToken, usuario.listar )

}