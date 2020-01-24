import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CrudService {

  constructor(private http: HttpClient) { }

  public sendHeald() {
    return this.http.get('https://zavz3o1ht9.execute-api.us-east-1.amazonaws.com/qa/auth/v1/campaign/profile/CC/1030638694')
  }
}
