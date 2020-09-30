<?php
namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Repositories\Permissao;

class Home{

    public function home(){
        if( session()->has('autenticado') ){
            return view('sistema.index');
        }else{
            return view('home.login');
        }
    }

}