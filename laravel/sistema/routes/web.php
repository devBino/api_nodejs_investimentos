<?php

use Illuminate\Support\Facades\Route;

Route::get('/','Home@home');

//LOGIN
Route::post('/login','Login@login');