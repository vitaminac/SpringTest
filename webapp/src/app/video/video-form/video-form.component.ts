import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../service/api.service";
import {NzMessageService, UploadFile} from "ng-zorro-antd";
import {VideoDTO} from "../videoDTO";
import {UtilsService} from "../../service/utils.service";
import {AppConfig} from "../../config/app.config";

@Component({
  selector: 'app-video-upload',
  templateUrl: './video-form.component.html',
  styleUrls: ['./video-form.component.css']
})
export class VideoFormComponent implements OnInit {
  uploading: boolean = false;
  coverUrl: string;
  loading = false;
  model: VideoDTO;
  cover: File;
  video: File;


  constructor(private api: ApiService,
              private msg: NzMessageService,
              private utils: UtilsService) {
  }

  ngOnInit() {
    this.reset();
  }

  reset() {
    this.model = new VideoDTO(null, null, null, null, null, null);
  }

  submit() {
    this.uploading = true;
    this.utils.postForm(this.api.VideoApi, {cover: this.cover, video: this.video}, this.model).subscribe(() => this.uploading = false);
  }

  get imageApi() {
    // TODO:fix
    return "/images/"
    // return this.api.ImageApi;
  }

  onBeforeUploadCover = (file: File) => {
    const isJPG = file.type === AppConfig.JPEG;
    if (!isJPG) {
      this.msg.error('You can only upload JPG file!');
    }
    const isLt2M = file.size / 1024 / 1024 < 2;
    if (!isLt2M) {
      this.msg.error('Image must smaller than 2MB!');
    }

    if (isJPG && isLt2M) {
      this.utils.convertFileToBase64(file, (content: string) => {
        this.coverUrl = content;
      });
      this.cover = file;
    }
    return false;
  };

  onBeforeUploadVideo = (file: File) => {
    // TODO check is media type
    if (file.type !== AppConfig.MP4) {
      this.msg.error('For now we only intent to support mp4!');
    } else {
      this.video = file;
    }
    return false;
  };

  get isValid(): boolean {
    return true; // TODO
  }
}
