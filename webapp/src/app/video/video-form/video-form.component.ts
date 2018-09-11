import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../service/api.service";
import {NzMessageService, UploadFile} from "ng-zorro-antd";
import {VideoDTO} from "../videoDTO";

@Component({
  selector: 'app-video-upload',
  templateUrl: './video-form.component.html',
  styleUrls: ['./video-form.component.css']
})
export class VideoFormComponent implements OnInit {
  submitted: boolean = false;
  coverUrl: string;
  loading = false;
  name: string;

  constructor(private api: ApiService,
              private msg: NzMessageService) {
  }

  ngOnInit() {
  }

  submit() {
    this.submitted = true;
  }

  get imageApi() {
    // TODO:fix
    return "/images/"
    // return this.api.ImageApi;
  }

  onBeforeUploadCover(file: File) {
    const isJPG = file.type === 'image/jpeg';
    if (!isJPG) {
      this.msg.error('You can only upload JPG file!');
    }
    const isLt2M = file.size / 1024 / 1024 < 2;
    if (!isLt2M) {
      this.msg.error('Image must smaller than 2MB!');
    }
    return isJPG && isLt2M;
  }

  // TODO: move to util
  private getBase64(img: File, callback: (img: {}) => void): void {
    const reader = new FileReader();
    reader.addEventListener('load', () => callback(reader.result));
    reader.readAsDataURL(img);
  }

  onCoverChange(info: { file: UploadFile }) {
    // TODO: nzChange, remove $event
    if (info.file.status === 'uploading') {
      this.loading = true;
      return;
    }
    if (info.file.status === 'done') {
      // Get this url from response in real world.
      this.getBase64(info.file.originFileObj, (img: string) => {
        this.loading = false;
        this.coverUrl = img;
      });
    }
  }
}
