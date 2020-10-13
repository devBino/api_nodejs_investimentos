<?php
namespace App\Http\Controllers;

class Dashboard{

    public function index(){
        $data = [];
        return view('dashboard.index');
    }

}