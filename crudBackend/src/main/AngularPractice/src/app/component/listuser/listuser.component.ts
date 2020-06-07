import { Component, OnInit } from '@angular/core';

import { UserService } from '../../shared-service/user.service';
import { User } from '../../user';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listuser',
  templateUrl: './listuser.component.html',
  styleUrls: ['./listuser.component.css']
})
export class ListuserComponent implements OnInit {
  private users: User[];

  constructor(private _userService: UserService, private _router: Router) {
  }

  ngOnInit() {
    //this._userService.getList().subscribe(data => this.users = data);
   // this.reloadData();

    console.log("hello");
    this._userService.getUsers().subscribe((users) => {
      console.log(users);
      this.users=users;
    });
    console.log(">>>> "+this._userService.getUsers());
    }

  //reloadData() {
    //this.users = this._userService.getUsers();
  //}

  deleteUser(user) {
    console.log(user.id);
    this._userService.deleteUser(user.id).subscribe((data) => {
      this.users.splice(this.users.indexOf(user, 1));
    })
  }

  updateUser(user) {
    this._userService.setter(user);
    this._router.navigate(['/op']);
  }

  newUser() {
    let user = new User();
    this._userService.setter(user);
    this._router.navigate(['/op']);
  }
}




