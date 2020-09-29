<?php
namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Repositories\ConsultaApi;

class Login{

    public function login(Request $request){
        //trata parametros
        $params = $request->all();

        if( isset($params['_token']) ){
            unset($params['_token']);
        }
        
        ConsultaApi::setUrl("http://localhost:3000/autenticacao/admin/d033e22ae348aeb5660fc2140aec35850c4da997");
        ConsultaApi::setParams($params);
        ConsultaApi::setMetodo("GET");
        
        $response = ConsultaApi::consultar();

        dd($response);
    }

}