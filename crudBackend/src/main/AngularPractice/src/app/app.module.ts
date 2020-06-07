import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HelloWorldComponent } from './hello-world/hello-world.component';
import { ListuserComponent } from './component/listuser/listuser.component';
import { UserComponent } from './component/user/user.component';
import { UserService } from './shared-service/user.service';

const appRoutes: Routes = [
  { path: '', component: ListuserComponent },
  { path: 'op', component: UserComponent }
]
@NgModule({
  declarations: [
    AppComponent,
    HelloWorldComponent,
    ListuserComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
