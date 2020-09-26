const mysql = require('mysql')
const env   = require('../../env')


/**
 * @author Fernando Bino
 * @description Classe responsavel por retornar instancia de conexão com banco
 * nesse mesmo repositório vamos fazer uma classe filha pra herdar a conexão
 * e para respeitar o princípio S de SOLID essa classe filha irá executar as queries
*/
class Connection{

    constructor(){
        this._con = null
    }

    getConnection(banco = null){
        let paramBanco = ( banco != null ) ? banco : 'ativos'
        
        let con = mysql.createPool({
            connectionLimit:10,
            ...{
                host:env.con.host,
                user:env.con.user,
                password:env.con.password,
                database:paramBanco
            }
        })

        return con
    }    

}

module.exports = Connection