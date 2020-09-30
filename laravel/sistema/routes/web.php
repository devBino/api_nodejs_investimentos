<?php

use Illuminate\Support\Facades\Route;

Route::get('/','Home@home');

//LOGIN
Route::post('/login','Login@login');
Route::get('/logout','Login@logout');

//SISTEMA
Route::get('/sistema','Sistema@index')->middleware(['IsOk']);