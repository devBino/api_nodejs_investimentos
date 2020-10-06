const env       = require('../../env')

class ParamsApi{

    constructor(){
        this._url = null
    }

    setUrl(strUrl){
        this._url = strUrl
    }

    getUrlCotacao(ativo){
        this._url = `https://api.hgbrasil.com/finance/stock_price?key=${env.chaveApiCotacoes}&symbol=${ativo}`
        return this._url
    }

}

module.exports = new ParamsApi()