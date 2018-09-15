import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../service/api.service";
import {NzMessageService, UploadFile} from "ng-zorro-antd";
import {VideoDto} from "../video.dto";
import {UtilsService} from "../../service/utils.service";
import {AppConfig} from "../../config/app.config";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-video-upload',
  templateUrl: './video-form.component.html',
  styleUrls: ['./video-form.component.css']
})
export class VideoFormComponent {
  uploading: boolean = false;
  coverUrl: string;
  cover: File;
  video: File;


  constructor(private api: ApiService,
              private msg: NzMessageService,
              private utils: UtilsService) {
  }

  submit(model) {
    this.uploading = true;
    this.utils.postForm(this.api.VideoApi, {cover: this.cover, video: this.video}, model).subscribe((event) => {
        this.uploading = false;
        this.msg.success('upload successfully.');
      },
      err => {
        this.uploading = false;
        this.msg.error('upload failed.');
      });
  }

  get imageApi() {
    // TODO:fix
    return "/images/"
    // return this.api.ImageApi;
  }

  onCoverChange = (file: File) => {
    if (file.size / 1024 / 1024 < 2) { // TODO: Angular input validation
      this.utils.convertFileToBase64(file, (content: string) => {
        this.coverUrl = content;
      });
      this.cover = file;
    } else {
      this.msg.error('Image must smaller than 2MB!');
    }
  };

  get allowCoverType(): string {
    return [AppConfig.JPEG, AppConfig.PNG].join(";");
  }

  get allowVideoType(): string {
    return AppConfig.MP4;
  }

  onVideoChange(file: File) {
    this.video = file;
  };
}
