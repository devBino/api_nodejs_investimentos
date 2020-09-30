<?php
namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Repositories\LoginRepositorie;
use App\Http\Validators\LoginValidator;
use App\Http\Repositories\Permissao;

class Login{

    public function login(Request $request){        
        
        Permissao::destruir();
        LoginRepositorie::setParams($request->all());
        
        if( LoginValidator::validarLogin( $request, LoginRepositorie::getToken()) && session()->has('autenticado') ){
            return redirect('/sistema');
        }else{
            return redirect('/');
        }        
    }

    public function logout(){
        Permissao::destruir();
        return redirect('/');
    }

}