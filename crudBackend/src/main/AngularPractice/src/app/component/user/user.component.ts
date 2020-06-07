import { Component, OnInit } from '@angular/core';
import { User } from '../../user';

import { Router } from '@angular/router';
import { UserService } from '../../shared-service/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  private user: User;

  constructor(private _userService: UserService, private _router: Router) {
  }

  ngOnInit() {
    this.user = this._userService.getter();

  }

  processForm() {
    if (this.user.id == undefined) {
      this._userService.createUser(this.user).subscribe((user) => {
        console.log(user);
        this._router.navigate(['/']);
      })
    } else {
      this._userService.updateUser(this.user).subscribe((user) => {
        console.log(user);
        this._router.navigate(['/']);
      })
    }
  }


}
