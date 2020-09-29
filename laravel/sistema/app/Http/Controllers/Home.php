<?php
namespace App\Http\Controllers;

use Illuminate\Http\Request;

class Home{

    public function home(){
        return view('home.login');
    }

}