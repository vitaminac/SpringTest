export class VideoDto {
  constructor(
    public id: number,
    public name: string,
    public uri: string,
    public  cover: string,
    public uploader: string,
    public  description: string) {
  };
}
