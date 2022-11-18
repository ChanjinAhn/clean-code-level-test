const grid = new tui.Grid({
  el: document.getElementById('grid'),
  data: {
    api: {
      readData: { url: '/api/readData', method: 'GET' }
    }
  },
  scrollX: false,
  scrollY: false,
  minBodyHeight: 30,
  rowHeaders: ['rowNum'],
  pageOptions: {
    perPage: 5
  },
  columns: [
    {
      header: 'Name',
      name: 'name'
    },
    {
      header: 'Artist',
      name: 'artist'
    },
    {
      header: 'Type',
      name: 'type'
    },
    {
      header: 'Release',
      name: 'release'
    },
    {
      header: 'Genre',
      name: 'genre'
    }
  ]
});