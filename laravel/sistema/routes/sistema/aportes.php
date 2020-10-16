<?php

use Illuminate\Support\Facades\Route;

Route::get('/aportes','Aporte@index');
Route::post('/aportes-salvar','Aporte@salvar');
Route::get('/aportes-deletar/{id}','Aporte@deletar');